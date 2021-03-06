def call(MVN_DEV_VERSION, MVN_RELEASE_VERSION, gitbranch, GIT_PASS)
     {
          sh '''
#               git clone https://github.com/anandjainsa/scripts.git /tmp/releasescripts
#               git clone git@github.com:anandjainsa/scripts.git /tmp/releasescripts
                sleep 5
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

                sh /tmp/releasescripts/gitrelease.sh ${MVN_RELEASE_VERSION} ${MVN_DEV_VERSION} ${gitbranch}
        '''
}

