def call(MVN_DEV_VERSION, MVN_RELEASE_VERSION, gitbranch, GIT_PASS)
     {
          sh '''
		export GIT_PASSWORD="${GIT_PASS}"
		export GIT_ASKPASS="/appdata/middleware/admin-scripts/gitpass.sh"
 
		if [ -z ${MVN_DEV_VERSION} ] || [ -z ${MVN_RELEASE_VERSION} ]
 
            	then
            		exit 0;
		fi
 
		if [ -d /tmp/releasescripts ]
		 then
           	   rm -rf /tmp/releasescripts
		fi
 
		#git clone https://jenkins_mobile@TTGSSDV0VRHCM01.TTGTPMG.NET/tpmg/middleware/scripts.git /tmp/releasescripts
		git clone git@TTGSSDV0VRHCM01.TTGTPMG.NET:tpmg/middleware/scripts.git /tmp/releasescripts
 
		sh /tmp/releasescripts/gitrelease.sh ${MVN_RELEASE_VERSION} ${MVN_DEV_VERSION} ${gitbranch}
 	'''
}

