require 'selenium'
require 'selenium-webdriver'
require 'date'

module OrderPage

  def wait
    wait = Selenium::WebDriver::Wait.new(timeout: 5)
    wait.until do
      yield
    end
  end

  def first_city_input_field browser
    wait do
      el = browser.find_element(xpath: '//input[@id = "origin"]')
      el.clear
      el
    end
  end

  def second_city_input_field browser
    wait do
      el = browser.find_element(xpath: '//input[@id = "destination"]')
      el.clear
      el
    end
  end

  def first_point_value
    "(LIS) Lisbon, Portugal"
  end

  def second_point_value
    "(ORY) Paris , France"
  end

  def bad_destination_point
    "Airport not found."
  end

  def bad_origin_point
    bad_destination_point
  end

  def bad_points
    "asdfjkh"
  end

  def alert_destination_point browser
    wait do
      browser.find_element(xpath: '//label[@id = "destination-error"]')
    end
  end

  def alert_origin_point browser
    wait do
      browser.find_element(xpath: '//label[@id = "origin-error"]')
    end
  end

  def bad_date_error_text
    "Please enter a valid date."
  end

  def not_valid_date
    (Date.today - 1)
  end

  def valid_date
    Date.today
  end

  def origin_date_alert browser
    wait do
      browser.find_element(xpath: '//label[@id = "dateDepartureOneWay-error"]')
    end
  end

  def origin_return_date_alert browser
    wait do
      browser.find_element(xpath: '//label[@id = "dateReturnTwoWays-error"]')
    end
  end

  def origin_date_input browser
    wait do
      el = browser.find_element(xpath: '//input[@id = "dateDepartureOneWay"]')
      el.clear
      el
    end
  end

  def click_one_way_only_box browser
    wait do
      browser.find_element(xpath: "//input[@id = 'journey-go']")
    end.click
  end

  def click_on_return_box browser
    wait do
      browser.find_element(xpath: "//input[@id = 'journey-return']")
    end.click
  end

  def origin_return_data_input browser
    wait do
      el = browser.find_element(xpath: '//input[@id = "dateDepartureTwoWays"]')
      el.clear
      el
    end
  end

  def destination_return_data_input browser
    wait do
      el = browser.find_element(xpath: '//input[@id = "dateReturnTwoWays"]')
      el.clear
      el
    end
  end

  def bad_dep_date
    "The return date cannot be earlier than the departure date."
  end

  def add_baby browser
    wait do
      el = browser.find_element(xpath: '//input[@id = "passengersTotalOneWay"]')
      el.clear
      el
    end
    el.click

  end
end