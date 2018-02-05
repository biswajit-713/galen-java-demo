environments {

    local {
        applicationUrl = "http://localhost:3000"
    }

    dev {
        applicationUrl = "https://dev.nmgcloudapps.com"
    }

    test {
        applicationUrl = "https://dev-int.nmgcloudapps.com"
    }

    integration {
        applicationUrl = "https://devint.neimanmarcus.com"
    }

    perf {
        applicationUrl = "https://ipv.neimanmarcus.com"
    }

    prodFake {
        applicationUrl = "https://prod.neimanmarcus.com"
    }
}
