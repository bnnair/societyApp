pipeline {
    agent any
    tools {
        maven 'M2_HOME'
        jdk 'jdk'
    }
    
    stages {
        
        stage ("build image") {
            steps {

                sshagent (["docker-server"]) {
                    sh """
		    	ssh -o StrictHostKeyChecking=no dockeradmin@172.31.8.139 uptime
			ssh dockeradmin@ip-172-31-8-139 ls -l
                    """
                }

            
        }
	}  
    
    }
}
