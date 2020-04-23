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
                        ssh dockeradmin@172.31.8.139 cd /home/dockeradmin 
			ssh dockeradmin@172.31.8.139 docker build -t bnnair/societyapp .
                        ssh dockeradmin@172.31.8.139 docker run -d -p 8080:8080 bnnair/societyapp
                    """
                }

            
        }
	}  
    
    }
}
