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
		    	ssh -o StrictHostKeyChecking=no ec2-user@172.31.8.139 uptime
			ssh ec20user@172.31.8.139 su - dockeradmin
                        ssh dockeradmin@172.31.8.139 /home/dockeradmin/docker build -t bnnair/societyapp .
                        ssh dockeradmin@172.31.8.139 /home/dockeradmin/docker run -d -p 8080:8080 bnnair/societyapp
                    """
                }

            
        }
	}  
    
    }
}
