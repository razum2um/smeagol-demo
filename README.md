# Smeagol demo business application

This is a sample application containing business logic.
Intended to be run behind smeagol via nrepl protocol

Smeagol uses releases of this repo inside its CI pipeline.

## Usage

Behind the scenes it should be started like this:

```bash
java -cp smeagol-demo-0.1.0-SNAPSHOT-standalone.jar:nrepl-0.6.1-SNAPSHOT.jar clojure.main -m nrepl.cmdline -b 127.0.0.1 -p 7888
```

then configured in smeagol's `config.edn`:

```edn
:test-namespaces {"smeagol-demo.ttl" #:smeagol.testing.execution{:host "127.0.0.1"
                                                                 :port 7888
                                                                 :type :remote
                                                                 :timeout 1000
                                                                 :release "https://...jar"}}
```

Nested keys are ns names delivering business logic,
e.g. this repo contains `smeagol-demo.ttl`):

Key `:release` is optional if you want to point smeagol to your persistent
environment.

Still, if `:release` is present and if `:host` == `127.0.0.1` and nothing
listens on `port`, exactly like happens on CI,
smeagol will run the application like shown above
automatically upon its initialization.

## License

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
