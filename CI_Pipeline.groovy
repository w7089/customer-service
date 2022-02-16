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
    }
}