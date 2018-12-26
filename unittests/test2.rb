require 'test/unit'
require './driver.rb'
require './order-page.rb'


class BadFirstPoint < Test::Unit::TestCase
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

  # Fake test
  def test_bad_first_point
    first_input = first_city_input_field @browser
    first_input.send_keys bad_points
    assert_equal(alert_origin_point(@browser).text, bad_origin_point)
  end
end