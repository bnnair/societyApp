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
        stage ("Copy to remote host") {
             steps {
               sshPublisher(publishers: [sshPublisherDesc(configName: 'docker-host', sshCredentials: [encryptedPassphrase: '{AQAAABAAAAAQqrAvIJ4BT/TWYD1IQPmIe5Q2c4p2+l6HuFwqCATQNLU=}', key: '', keyPath: '', username: 'dockeradmin'], transfers: [sshTransfer(cleanRemote: false, excludes: '', execCommand: '', execTimeout: 120000, flatten: false, makeEmptyDirs: false, noDefaultExcludes: false, patternSeparator: '[, ]+', remoteDirectory: '.', remoteDirectorySDF: false, removePrefix: 'target', sourceFiles: 'target/*.jar')], usePromotionTimestamp: false, useWorkspaceInPromotion: false, verbose: false)])
            }   
        }
    }
}
