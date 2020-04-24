def call(HOSTNAME, PORT){
    sh '''
       scp -rv -o StrictHostKeyChecking=no target/*.war vagrant@${HOSTNAME}:/opt/${PORT}/webapps/
        '''
}
