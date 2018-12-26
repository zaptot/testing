require './driver.rb'

driver = Driver.new

browser = driver.start_driver

driver.open_page  browser, "https://google.by"

driver.stop_driver browser

gets