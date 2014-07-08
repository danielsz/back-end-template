A-la-carte components for Clojure
=================

Leiningen template to kickstart Clojure applications with REPL-controlled dependencies (startable, stoppable). Based on Stuart Sierra's reloaded pattern.

Includes support for:

* Datomic
* MongoDB
* RabbitMQ
* Jetty webserver
* Remote REPL

## Usage

   $ lein new back-end-template my-app

Define your environments in `application.clj`

During development, type `(user/start)`, `(user/stop)` and `(user/reset)` in the REPL.
In production, the `-main` entry point is preset to start the system.

In both environments, the components are accessible from the system map, which you call with `(system-map)`.

That's it!

## Contributing
Please fork and issue a pull request to add more components.
