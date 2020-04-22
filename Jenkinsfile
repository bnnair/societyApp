pipeline {
    agent{
        docker-host {
            image 'maven:3-alpine' 
        }
    }
    stages {
        stage ("Build") {
            steps {
                sh "mvn clean install package"
            }
        }
    }
}
