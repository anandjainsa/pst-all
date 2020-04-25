def call(gitbranch, GIT_PASS)
     {
          sh '''
                export GIT_PASSWORD="${GIT_PASS}"
                export GIT_ASKPASS="/tmp/release/gitpass.sh"

                if [ -z ${MVN_DEV_VERSION} ] || [ -z ${MVN_RELEASE_VERSION} ]

                then
                        exit 0;
                fi

                if [ -d /tmp/releasescripts ]
                 then
                   rm -rf /tmp/releasescripts
                fi
                git clone git@github.com:anandjainsa/scripts.git /tmp/releasescripts

                MVN_RELEASE_VERSION=`mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout | cut -d"-" -f1`

                sh /tmp/releasescripts/gitrelease.sh ${MVN_RELEASE_VERSION} ${gitbranch}
        '''
}

