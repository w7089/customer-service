pipeline {
    agent  {
        label 'jdk8'
    }

    stages {

        stage("package") {
            steps {
                script {
                    sh "mvn clean package"
                }
            }
        }
        stage("build image") {
            agent  {
                label 'docker-agent'
            }
            steps {
                script {
                    // TODO use docker pipeline plugin
                    sh "docker build -t sample-java8-app:latest ."
                }
            }
        }
    }
}