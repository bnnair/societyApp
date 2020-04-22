pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'jdk'
    }
    
    stages {
        stage ("Build") {
            steps {
                sh "mvn clean package"
            }
        }
    }
}
