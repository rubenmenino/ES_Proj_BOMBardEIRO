pipeline {
    agent any
    stages {
        stage('Cloning repository') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/rubenmenino/ES_Proj_BOMBardEIRO.git'
                    
                )
                sh "chmod +x -R ${env.WORKSPACE}"
        }
            
        stage('Start') {
            steps{
                dir('esp11'){
                    sh '''
                        echo "PATH = ${PATH}"
                        echo "M2_HOME = ${M2_HOME}"
                        '''
                }
            }

        }
        stage('Build') {
            steps{
                dir('esp11'){
                    sh 'mvn -Dmaven.test.failure.ignore=true install'
                }
            }

        }

        stage('Deploy') {
            steps{
                sh 'mvn -f esp11/pom.xml -B -DskipTests clean package'
            }
        }

         stage('Test') {
            steps {
                dir("esp11") {
                    echo "Testing"
                    sh "mvn test"
                }
            }
        }

       //stage('docker-compose') {
        //   steps {
         //     sh "docker-compose build"
          //    sh "docker-compose up -d"
           //}
       //}

   }
   post {
     always {
        sh "docker-compose down || true"
     }
   }

}
