# Mule Varnish Module

Varnish is an HTTP accelerator designed for content-heavy dynamic web sites. In contrast to other HTTP accelerators, such as Squid, which began life as a client-side cache, or Apache and nginx, which are primarily origin servers, Varnish was designed as an HTTP accelerator. Varnish is focused exclusively on HTTP, unlike other proxy servers that often support FTP, SMTP and other network protocols.

This module will allow you to interact with Varnish Administration port and sending instructions like banning and purging cache.

## Installation

The module can either be installed for all applications running within the Mule instance or can be setup to be used
for a single application.

*All Applications*

Download the module from the link above and place the resulting jar file in
/lib/user directory of the Mule installation folder.

*Single Application*

To make the module available only to single application then place it in the
lib directory of the application otherwise if using Maven to compile and deploy
your application the following can be done:

Add the connector's maven repo to your pom.xml:

    <repositories>
        <repository>
            <id>mule-ee-snapshots</id>
            <name>Mule Snapshot Repository</name>
            <url>http://dev.ee.mulesource.com/repository/content/repositories/snapshots/</url>
            <layout>default</layout>
        </repsitory>
    </repositories>

Add the connector as a dependency to your project. This can be done by adding
the following under the dependencies element in the pom.xml file of the
application:

    <dependency>
        <groupId>org.mule.modules</groupId>
        <artifactId>mule-module-varnish</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>

## Usage

