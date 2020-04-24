@Library('pstsharedlibrary')_
pipeline {

agent any
//    agent {
//        label "nodename"
//    }

    tools {
        // Note: this should match with the tool name configured in your jenkins instance (JENKINS_URL/configureTools/)

        maven "maven3"
        jdk "java1.8"
    }

environment {
        //  Define all variables
        MVN_RELEASE_VERSION = "0.0.1"
        MVN_DEV_VERSION = "0.0.2-SNAPSHOT"
        gitbranch="env.BRANCH_NAME"
       }  

    stages {
       stage("PreBuild Steps") {
            steps {
              preBuild("${MVN_RELEASE_VERSION}");
               } 
           }

/*       stage("Build") {
            steps {
              mavenBuild();
               }
            post {
               success {
                    // we only worry about archiving the jar file if the build steps are successful
                    archiveArtifacts(artifacts: '**target*.jar', allowEmptyArchive: true)
                }
             }
          }


        stage('Deploy to Tomcat'){
            steps {
                  sshagent(['my-ssh-key']) {
                  sh 'scp -rv -o StrictHostKeyChecking=no target/*.war vagrant@192.168.33.11:/opt/tomcat/webapps/'
            }
       }
   }
        stage("Release Tag") {

            steps {
                  withCredentials([usernamePassword(credentialsId: 'gitcreds', usernameVariable: 'USERNAME', passwordVariable: 'GIT_PASS')]) {
                  script {
                      GIT_PASS = "${env.GIT_PASS}"
                      }
                  mavenReleaseTag("${MVN_DEV_VERSION}", "${MVN_RELEASE_VERSION}", "${gitbranch}", "${GIT_PASS}" )
                  }
                }
        }
    }
    post {
        always {
            sendNotifications("currentBuild.result")
        }
*/    }
}
