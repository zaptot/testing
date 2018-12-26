require 'test/unit'
require './driver.rb'
require './order-page.rb'

class BabyWithoutAdults < Test::Unit::TestCase
  include OrderPage
  def setup
    @driver = Driver.new
    @browser = @driver.start_driver
    @driver.set_normal_window_size @browser
    @driver.open_order_page @browser
  end

  def teardown
    @driver.stop_driver @browser
  end

  def test_fail

  end
end