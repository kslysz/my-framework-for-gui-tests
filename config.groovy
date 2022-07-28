appUrl = 'https://github.com/'

browser {
    size = "1920x1080"
    headless = true
}

environments {
    local { // default configuration
        browser {
            size = "1530x820"
            headless = false
        }
    }

    dev {

    }

}