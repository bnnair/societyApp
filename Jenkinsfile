  def remote = [:]
  remote.name = 'docker-server'
  remote.host = '172.31.8.139'
  remote.allowAnyHosts = true

pipeline {
    agent any
    
	
     tools {
        maven 'M2_HOME'
        jdk 'jdk'
    }
    
    stages {
        
        stage ("build image") {
            steps {

                sshagent (credentials:["docker-server"]) {
                    sh """
		    	ssh -o StrictHostKeyChecking=no dockeradmin@172.31.8.139
		
                    """
                }

            
        }
	}  
    
    }
}
