(ns launchdarkly-hello-clojure.core
  (:import [com.launchdarkly.client LDClient LDUser LDUser$Builder]
           [com.launchdarkly.client.value LDValue]))

(def SDK_KEY (System/getenv "SDK_KEY"))
(def FEATURE_FLAG_KEY "a-boolean-feature")

(defn- ld-value ^LDValue []
  (-> (LDValue/buildArray)
      (.add "beta_testers")
      (.build)))

(defn -main [& args]
  (assert ((complement empty?) SDK_KEY) "Please set SDK_KEY env var to your LaunchDarkly SDK key first")
  (let [client (LDClient. SDK_KEY)
        user (-> (LDUser$Builder. "bob@example.com")
                 (.firstName "Bob")
                 (.lastName "Loblaw")
                 (.custom "groups" (-> (LDValue/buildArray)
                                       (.add "beta_testers")
                                       (.build)))
                 (.build))]
    (println (format "Feature flag %s is %s for this user." 
                     FEATURE_FLAG_KEY 
                     (.boolVariation client FEATURE_FLAG_KEY user false)))
    ))
