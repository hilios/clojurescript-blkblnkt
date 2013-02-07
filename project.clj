(defproject sim-cljs "0.1.0-SNAPSHOT"
  :description "Test development environment for Clojure + ClojureScript stack"
  :url "http://simloovoo.com"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [aleph "0.3.0-beta11"]
                 [ring "1.1.8"]
                 [compojure "1.1.5"]
                 [enlive "1.0.1"]
                 [enfocus "1.0.0-beta3"]
                 [com.cemerick/piggieback "0.0.2"]
                 [domina "1.0.1"]
                 [watchtower "0.1.1"]]
  :plugins [[lein-cljsbuild "0.2.8"]
            [lein-ring "0.8.2"]]
  :repl-options {:nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}
  :hooks [leiningen.cljsbuild]
  :cljsbuild { 
    :builds {
      :main {
        :source-path "src-cljs"
        :compiler
        {
          :output-to "resources/public/js/cljs.js"
          :optimizations :simple
          :pretty-print true
        }
        :jar true
      }
    }
  }
  :ring {:handler sim-cljs.server/app}
  :main sim-cljs.server)