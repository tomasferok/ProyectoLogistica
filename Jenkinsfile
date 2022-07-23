pipeline {
    agent {
        node {
            label 'ubuntu-2004'
        }
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
                googleStorageUpload(pattern: '/tmp/workspace/ectoLogistica_feature_despliegue/target/LogisticaApp-0.0.1-SNAPSHOT.jar', bucket: 'gs://clawtech-logistica-proyecto-jenkins-artifacts/springboot/$JOB_NAME/$BUILD_NUMBER', credentialsId: 'clawtech-logistica-proyecto')
            }
        }

        stage('Test') {
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
            steps {
                sh 'mvn test'
                        emailext(subject: 'Jenkins Notificación IMPORTANTE', attachLog: true, body: 'Resultados de test:', to: 'guillermo.rodriguez@estudiantes.utec.edu.uy')

            }
        }

        // stage('Espera Autorizacion') {
        //     steps {
        //         input '¿Autoriza realizar el despliegue a produccion?'
        //     }
        // }

        stage('Deliver') {
            steps {
                sh 'mvn -DskipTests package appengine:deploy -P gcp'
            }
        }
    }

    tools {
        maven 'maven'
    }
}
