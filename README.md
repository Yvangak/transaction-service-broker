# transaction-service-broker
This repository is a demo implementation of a transaction service with a message broker.
- spring cloud stream
- RabbitMq

# Use docker to get an image of rabbitmq then start a container
- docker pull rabbitmq
- docker run -d --hostname yvan-rabbit --name transactions-rabbit-demo -p 15672:15672  -p 5672:5672 rabbitmq:3-management
