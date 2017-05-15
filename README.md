# origin_stamp-java-library
This library provides an implemented Java Interface to the OriginStamp API. The library supports Java developers to create new applications for the OriginStamp Trusted Timestamping Service: https://www.originstamp.org

The framework is based on Reactive Java which allows to easily deal with asynchronous callbacks.

Check out the Wiki Page on how to use the library.

Welcome to the origin_stamp-java-library wiki!

The following instructions introduce you to the capabilities of this library and explains how to use them.


# API Key

Before we start with implementing a new fancy application that is based on Trusted Time-Stamping, we need to retrieve an API Key.

1. Go to: https://www.originstamp.org and move to the developer section on the bottom.
2. Create a new API Key and use the provided credentials: API Url + API Key

# Apache Maven

Add the following lines to your pom.xml

    <repositories>
      <repository>
          <id>jitpack.io</id>
          <url>https://jitpack.io</url>
      </repository>
    </repositories>


and finally the dependency

    <dependency>
        <groupId>com.github.ag-gipp</groupId>
        <artifactId>origin_stamp-java-client</artifactId>
        <version>v1.0.3</version>
    </dependency>


# Gradle

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}

Add the dependency

        dependencies {
		compile 'com.github.ag-gipp:origin_stamp-java-client:v1.0.3'
	}


# Configuration
    private static final String YOUR_API_KEY="PUT THE API KEY HERE";
    private static final String YOUR_API_HOST="PUT THE HOST ADDRESS HERE";
    .
    .
    .
    /**
     * generate dummy configuration
     *
     * @return
     */
    private static OriginStampConfiguration getConfiguration() {
        // init new object
        OriginStampConfiguration originStampConfiguration = new OriginStampConfiguration();
        // set params
        originStampConfiguration.setApiKey(YOUR_API_KEY);
        originStampConfiguration.setHost(YOUR_API_HOST);
        // return
        return originStampConfiguration;
    }

# API Calls

The library actually does not perform any API calls, but provides Observables based on Rx Java: https://github.com/ReactiveX/RxJava

Please get informed of RxJava before, you start working with the OriginStamp Java Client.

A sample could look as follows: This sample shows how to retrieve the 20 recently submitted timestamps.

            OriginStamp originStamp = new OriginStamp(getConfiguration());
            originStamp.getHashesForNoFilter(0, 20).subscribe(new Subscriber<OriginStampTableEntity>() {

            public void onCompleted() {
                // completed
            }

            public void onError(Throwable throwable) {
               // handle error
            }

            public void onNext(OriginStampTableEntity originStampTableEntity) {
                System.out.println("hashes: " + originStampTableEntity.getHashes().size());

                for (int i = 0; i < originStampTableEntity.getHashes().size(); i++) {
                    System.out.println(originStampTableEntity.getHashes().get(i).getHashString());
                    System.out.println(originStampTableEntity.getHashes().get(i).getDateCreated());
                    System.out.println(originStampTableEntity.getHashes().get(i).getSubmitStatus().getMultiSeed() + "\t" + originStampTableEntity.getHashes().get(i).getSubmitStatus().getSingleSeed());
                    System.out.println("#############################");
                }
            }
        });


Please check the other pages for the full functionalities of the library.
