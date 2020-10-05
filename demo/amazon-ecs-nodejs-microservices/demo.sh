# ---- Rodar monolito localmente ----
cd 2-containerized
npm install
npm start

curl localhost:3000/api/users
curl localhost:3000/api/threads


# ---- Rodar monolito no Docker localmente ----

docker build -t api .
docker run -d -p 3000:3000 --name my_api api


# ---- Criar repositório de container images ---

# https://us-east-1.console.aws.amazon.com/ecr/repositories?region=us-east-1

# ---- Login AWS / Docker ----
REGION=us-east-1
AWS_ACCOUNT_ID=004629672140

aws ecr get-login-password --region $REGION | docker login --username AWS --password-stdin $AWS_ACCOUNT_ID.dkr.ecr.$REGION.amazonaws.com
./login.sh

# ---- Fazer build, criar tag e enviar imagem para repositorio

docker tag api:latest $AWS_ACCOUNT_ID.dkr.ecr.us-east-1.amazonaws.com/api:v1
docker push $AWS_ACCOUNT_ID.dkr.ecr.us-east-1.amazonaws.com/api:v1

# ---- Criar Stack no Cloud Formation ----

cd ../../
aws cloudformation deploy \
   --template-file infrastructure/ecs.yml \
   --region us-east-1 \
   --stack-name BreakTheMonolith-Demo \
   --capabilities CAPABILITY_NAMED_IAM


# ---- Criar definicao de tasks dos containers

# https://console.aws.amazon.com/ecs/home?region=us-east-1#/taskDefinitions

# ---- Mostrar código monolítico e microservices ---- 

# ---- Criar recursos para microservice


# ---- Generage load -----

hey -n 10000 http://break-ecsal-5x58a57c1flm-2078849481.us-east-1.elb.amazonaws.com/api/users
hey -n 10000 http://break-ecsal-5x58a57c1flm-2078849481.us-east-1.elb.amazonaws.com/api/posts
hey -n 10000 http://break-ecsal-5x58a57c1flm-2078849481.us-east-1.elb.amazonaws.com/api/threads

# ---- Deploy microservices ----
cd 3-microservices/
./deploy.sh us-east-1 BreakTheMonolith-Demo

# ---- Mudar api service para 0 tasks
# ECS -> Cluster -> Service -> Update -> Number of tasks -> 0
