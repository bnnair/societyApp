pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'jdk'
    }
    
    stages {
        
        stage ("build image") {
            steps {

                sshagent (['docker-server']) {
                    sh """
                        ssh dockeradmin@172.31.8.139 /home/dockeradmin/docker build -t bnnair/societyapp .
                        ssh dockeradmin@172.31.8.139 /home/dockeradmin/docker run -d -p 8080:8080 bnnair/societyapp
                    """
                }

            
        }
	}  
    
    }
}
