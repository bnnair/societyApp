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
        stage ("Copy to remote host and build/run the image") {
            steps {
                sshPublisher(
                    publishers: [
                        sshPublisherDesc(
                            configName: 'docker-host', 
                            sshCredentials: 
                                [encryptedPassphrase: '{AQAAABAAAAAQqrAvIJ4BT/TWYD1IQPmIe5Q2c4p2+l6HuFwqCATQNLU=}', 
                                key: '', 
                                keyPath: '', 
                                username: 'dockeradmin'], 
                            transfers: [
                                sshTransfer(
                                    cleanRemote: false, 
                                    excludes: '', 
                                    execCommand: '', 
                                    execTimeout: 120000, 
                                    flatten: false, 
                                    makeEmptyDirs: false, 
                                    noDefaultExcludes: false, 
                                    patternSeparator: '[, ]+', 
                                    remoteDirectory: '.', 
                                    remoteDirectorySDF: false, 
                                    removePrefix: 'target', 
                                    sourceFiles: 'target/*.jar'
                                ),
                                sshTransfer(
                                        execCommand: "docker build -t bnnair/societyapp ." 
                                ),
                                sshTransfer(
                                        execCommand: "docker run -d -p 8080:8080 bnnair/societyapp" 
                                )
                            ], 
                                usePromotionTimestamp: false, 
                                useWorkspaceInPromotion: false, 
                                verbose: false
                    ]   )
                )
             }   
        }
    }
}
