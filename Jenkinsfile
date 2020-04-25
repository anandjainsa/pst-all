@Library('pst-all')_
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
         HOSTNAME = "192.168.33.11"
         PORT = "tomcat"
        //  Define all variables
        gitbranch="developemet"
       }  
    options {
        // Only keep the 10 most recent builds
        buildDiscarder(logRotator(numToKeepStr:'2'))
    }

    stages {
       stage("PreBuild Steps") {
            steps {
              preBuild();
               } 
           }

       stage("Build") {
            steps {
              mavenBuild();
               }
            post {
               success {
                    // we only worry about archiving the jar file if the build steps are successful
                    archiveArtifacts(artifacts: '**/target/*.jar', allowEmptyArchive: true)
                }
             }
          }


        stage('Deploy to Tomcat'){
            steps {
                  sshagent(['my-ssh-key']) {
                  tomcatDeploy("{HOSTNAME}","{PORT}");
            }
       }
   }
        stage("Release Tag") {

            steps {
                  withCredentials([usernamePassword(credentialsId: 'gitcreds', usernameVariable: 'USERNAME', passwordVariable: 'GIT_PASS')]) {
                  script {
                      GIT_PASS = "${env.GIT_PASS}"
                      }
                  mavenReleaseTag("${gitbranch}", "${GIT_PASS}" )
                  }
                }
        }
    }
    post {
        always {
            sendNotifications("currentBuild.result")
        }
    }
}
