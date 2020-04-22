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
                sh "mv target/*.jar target/societyapp.jar"
            }
        }
        stage ("Copy to remote host") {
             steps {
               sshPublisher(publishers: [sshPublisherDesc(configName: 'docker-host', sshCredentials: [encryptedPassphrase: '{AQAAABAAAAAQqrAvIJ4BT/TWYD1IQPmIe5Q2c4p2+l6HuFwqCATQNLU=}', key: '', keyPath: '', username: 'dockeradmin'], transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '.', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: 'target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }   
        }
        stage ("build image") {
            steps {
                sshagent (credentials: ['docker-host']) {
                    sh """
                        ssh dockeradmin@172.31.8.139 /home/dockeradmin/docker build -t bnnair/societyapp .
                        ssh dockeradmin@172.31.8.139 /home/dockeradmin/docker run -d -p 8080:8080 bnnair/societyapp
                    """
                }
            }
            
        }
    
    
    }
}
