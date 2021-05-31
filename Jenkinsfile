pipeline {
    agent any
    stages {
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
                sh 'mvn deploy -f ./esp11/pom.xml -s settings.xml'
            }

        }

   }

}
