FROM java:8

MAINTAINER malaoui<mehdi.alaoui@capgemini.com>

#RUN apt-get update

ADD *.jar /etc/synapsis/synapsis-projet/synapsis-projet.jar
ADD docker/run.sh /etc/synapsis/synapsis-projet/run.sh

RUN chmod +x /etc/synapsis/synapsis-projet/synapsis-projet.jar
RUN chmod +x /etc/synapsis/synapsis-projet/run.sh

ENV USER_DB_SYNAPSIS ${USER_DB_SYNAPSIS}
ENV PASSWORD_DB_SYNAPSIS ${PASSWORD_DB_SYNAPSIS}

RUN export $USER_DB_SYNAPSIS
RUN export $PASSWORD_DB_SYNAPSIS

EXPOSE 8080

ENTRYPOINT ["bash","run.sh"]

WORKDIR /etc/synapsis/synapsis-projet