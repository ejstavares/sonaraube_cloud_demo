[![ASL 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/NOSiCode-CV/IGRP-Java-Template-Eclipse/blob/master/README.md)

[<img src="https://raw.githubusercontent.com/NOSiCode-CV/IGRP-Framework/master/docs/root-images/logo_igrp.png">](http://www.igrp.cv)


**Running the Project**

To start the application locally, you can use the following Maven command:

```bash
mvn package tomee:run
```

This command will package the application and deploy it to an Apache TomEE server, which will run the web application on your local machine.

Once the server is up and running, you can access the application using the following link in your web browser:

```
http://127.0.0.1:8080/{artifactId}
```

Replace `{artifactId}` with the actual artifact ID of your generated project.

After accessing the link, you should be able to interact with the web application in your browser.

Keep the terminal with the running TomEE server open as long as you want the application to be available locally. If you wish to stop the server, you can use `Ctrl+C` in the terminal to terminate it.
