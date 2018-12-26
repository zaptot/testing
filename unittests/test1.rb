require 'test/unit'
require './driver.rb'
require './order-page.rb'

class TwoSamePoints < Test::Unit::TestCase
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

  def test_same_points
    first_input = first_city_input_field @browser
    second_input = second_city_input_field @browser
    first_input.send_keys first_point_value
    second_input.send_keys first_point_value
    assert_equal(bad_destination_point, alert_destination_point(@browser).text)
  end
end