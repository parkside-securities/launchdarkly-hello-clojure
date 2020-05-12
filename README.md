# LaunchDarkly Sample Clojure Application

This repo is to demonstrate the interoperability between LaunchDarkly Java SDK and Clojure program.

## Build instruction
- Install [Clojure CLI](https://clojure.org/guides/getting_started)
- set LaunchDarkly SDK key to `SDK_KEY` environment variable.
- Create a feature flag with `a-boolean-feature` as the id. You can change the key in `src/launchdarkly_hello_clojure/core.clj` if necessary.
- Run the program and observe the log output.

```clojure
clojure -m launchdarkly-hello-clojure.core
```



