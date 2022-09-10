# Service Account GCP demo

Log in  GCP console and click on the hamburger icon at the top left corner.
Hover on IAM & Admin > click on Service Accounts.
Click on + Create Service Account.
Provide Service Account Details including the account Name, ID, and Description. Click Create.
Provide role  for the project. Add "Cloud Storage Adminstrator" rol
Click on + Create Key.
Select the Key Type as JSON and click Create. 

Set the path of json file in environment variable GOOGLE_APPLICATION_CREDENTIALS

Mac/linux

```cmd
export GOOGLE_APPLICATION_CREDENTIALS=/<path-file.json>
```
Windows
```cmd
set GOOGLE_APPLICATION_CREDENTIALS=/<path-file.json>
````
## Java Project
Create project with **Spring Initializr** using Maven, whitout dependencies, this project create a bucket in Cloud Storage (GCP)

Convert application in command line app, implements CommandLineRunner

```java
@SpringBootApplication
public class DemoApplication implements CommandLineRunner{
```

Add unimplemented methods, add dependency Google Cloud Storage in pom.xml https://mvnrepository.com/artifact/com.google.cloud/google-cloud-storage/2.11.3

```xml
<!-- https://mvnrepository.com/artifact/com.google.cloud/google-cloud-storage -->
<dependency>
    <groupId>com.google.cloud</groupId>
    <artifactId>google-cloud-storage</artifactId>
    <version>2.11.3</version>
</dependency>
```

In method *run* add code for GCP Storage

Imports:

```java
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
```

Method:

```java
	@Override
	public void run(String... args) throws Exception {
		String projectId = "my-gcp-project-id";
		String bucketName="bucketdemoir02";
		Storage storage = StorageOptions.newBuilder().setProjectId(projectId).build().getService();
		storage.create(BucketInfo.of(bucketName));
	}
```

*!!!* Set projectId and bucketName with correct values