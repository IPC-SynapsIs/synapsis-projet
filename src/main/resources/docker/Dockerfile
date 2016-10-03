FROM java:8

MAINTAINER malaoui<mehdi.alaoui@capgemini.com>

#RUN apt-get update

ADD build/libs/*.jar /etc/synapsis/synapsis-projet/synapsis-projet.jar
ADD src/main/resources/docker/run.sh /etc/synapsis/synapsis-projet/run.sh

RUN chmod +x /etc/synapsis/synapsis-projet/synapsis-projet.jar
RUN chmod +x /etc/synapsis/synapsis-projet/run.sh

EXPOSE 8080

ENTRYPOINT ["bash","run.sh"]

WORKDIR /etc/synapsis/synapsis-projet
