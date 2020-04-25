def call()
     {
          sh '''
                MVN_RELEASE_VERSION=`mvn org.apache.maven.plugins:maven-help-plugin:3.1.0:evaluate -Dexpression=project.version -q -DforceStdout | cut -d"-" -f1`
		git checkout -b develop
		if [ ! -z $MVN_RELEASE_VERSION ]
				then
		git checkout -b release/${MVN_RELEASE_VERSION} develop
		 fi

                  '''
 }
