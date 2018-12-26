require 'selenium'
require 'selenium-webdriver'

class Driver

  def initialize
    @order_page_url = "https://www.flytap.com/en-pt/"
  end

  def start_driver
    capabilities = {'browserName': 'firefox', 'marionette': True, 'acceptInsecureCerts': True}
    Selenium::WebDriver.for(:remote, :url => "http://localhost:4444/wd/hub", :desired_capabilities => capabilities)
  end

  def set_normal_window_size browser
    browser.manage.window.resize_to(1500, 1500)
  end

  def open_page browser, url
    if browser
      browser.get url
    end
  end

  def stop_driver browser
    browser.quit
  end

  def open_order_page browser
    if browser
      browser.get @order_page_url
    end
  end

end
