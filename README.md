# sbj-translate (Spring Boot Java - Translate)
Application to translate texts into other languages

# swagger
http://localhost:9093/swagger-ui/index.html#/

# docker-build
docker build --no-cache -f Dockerfile -t sbj-traductor:1.0.0 .

# docker-run
docker run -d --name traductor -p 9093:9093 sbj-traductor:1.0.0

# docker-rm
docker rm -f traductor
