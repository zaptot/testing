require 'selenium'
require 'selenium-webdriver'

class Driver

  def initialize
    @order_page_url = "https://www.flytap.com/en-pt/"
  end

  def start_driver
    deviceId = 'HT1BET1345GVF2VJ619'
     
    caps = {
    :deviceName            => deviceId,
    :browser_name          => 'chrome',
    :javascript_enabled    => true,
    :takes_screenshot      => true,
    # add a Wind Tunnel perosna to the script. See https://community.perfectomobile.com/series/24692/posts/1048052
    :windTunnelPersona => "Georgia"
    }
    Selenium::WebDriver.for(:remote, :url => "http://localhost:4444/wd/hub")
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
