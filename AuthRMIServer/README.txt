
Building Secure RMI Servers
by Paulo Marques

-------------------------------------------------------------------------

In these directories you will find the source code and executables needed
for running the example of the article. All scripts where written for the
Windows family of OS'. If you are running Unix, you will have to change
those scripts accordingly.

DIRECTORY CONTENTS

.\classes           - Where the classes are outputted by the javac
.\src               - The source code
.\deployment        - The files needed for running the example
.\deployment\config - Where the configuration files live


INSTALLING

  If you are using JDK1.3 then the first thing you will need to do is
  to download JAAS from Sun, and install it locally. You can either put
  it on the local classpath or install it as a standard extension (which
  I recommend). For that just copy the jaas.jar file to your JRE's
  "lib\ext" directory (normally: "c:\jdk1.3\jre\lib\ext"). The
  batch files assume that you have JAAS as an installed extension.

  If you are using JDK1.4 then JAAS is already integrated in the JDK and
  you don't have to do anything.


COMPILING

  For compiling the code you will have to run "compile.bat" on the
  ".\deployment" directory. That will take care for compiling the
  code and creating the necessary jar files (deploy). You can also use
  the "JBuilder 5" project file present on the root directory. In that
  case you will only need to run the "deploy.bat" file for creating
  the necessary jars.

  Note: the code already comes compiled, so you only need to
  recompile if you change the source code.


RUNNING THE EXAMPLE

  For running the examples, you must be at the ".\deployment" directory,
  and have the code compiled and deployed (see the previous step).

  Open two different windows on your local machine. In the first
  one run "MyServer". That will bring up the server. In the second
  one, run "MyClient root rootPass". You should see both operations
  succeeding on the server.

  The ".\deployment\config" contains the policy files and the
  password files. You may try to use different users and policies.
  You can also run the client on a different machine. Just use
  "MyClient <username> <password> <server machine> as command".


THE CONFIGURED USERS AND PASSWORD

  The only configured users in the system are:

    Username          Password
    --------------------------
    root              rootPass
    alice             guess
    guest             guest

