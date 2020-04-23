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
			ssh dockeradmin@35.154.178.162 ls -l
                    """
                }

            
        }
	}  
    
    }
}
