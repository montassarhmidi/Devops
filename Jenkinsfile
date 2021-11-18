pipeline {
    

    environment { 
        registry = "montassarhmidi/devops" 
        registryCredential = 'dockerHub' 
        dockerImage = '' 
    }
    agent any
    stages {
         stage('Cloning our Git') { 
            steps { 
            echo 'Cloning!';
            git branch:'monta',
                         url:  'https://github.com/MariemAM/devopsProject2.git' 
                     
            }
        } 
    stage("Build Project") {
            steps {
                echo "Building ..."
                bat 'mvn package'
            }
        }
        stage('JUnit Test ') {
       
       steps{
           echo "Test ..."
           bat 'mvn test '
       }
    }
        
         stage('Sonar') {
            steps {
                echo "Analyzing quality code "
                bat 'mvn sonar:sonar'
            }
        }
        
       
      stage('Nexus') {
            steps {
                echo "delivrable artefacts."
                bat """mvn clean package deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=Timesheet-spring-boot-core-data-jpa-mvc-REST-1 -Dversion=1.1 -DgeneratePom=true -Dpackaging=war -DrepositoryId=EntrepriseRepository -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/Timesheet-spring-boot-core-data-jpa-mvc-REST-1-1.4.war """
        }
        }
       stage('Building our image') { 
            steps { 
                         script { 
                    dockerImage = docker.build registry + ":$BUILD_NUMBER" 
                }
            } 
        }
        stage('Deploy our image') { 
            steps { 
                script { 
                    docker.withRegistry( '', registryCredential ) { 
                        dockerImage.push() 
                    }
                } 
            }
        } 
       stage('Cleaning up') {
steps { bat "docker rmi $registry:$BUILD_NUMBER" }
}
              
}
        
     post {  
       
      always {
        
mail bcc: '',          body: "${env.BUILD_URL} has result ${currentBuild.result}", subject: "Status of pipeline: ${currentBuild.fullDisplayName}", to: 'montassar.hmidi@esprit.tn'
     } 
     
     }
} 