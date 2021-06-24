/// <reference types="cypress" />
import * as selectRaceFuncs from '../pages/atgHorseRaceSelection'
describe('Verify V4 Horse Race selection and Creating Coupon.', () => {
    it('Select V4 Race', () => {
      cy.visit('https://atg.se')
      cy.get('#onetrust-accept-btn-handler').click()
      cy.get('[data-test-id="overlay-side-menu"]').click()
      cy.get('[data-test-id="horse-verticals-menu"]').click()
      cy.get('[data-test-id="gameType-horse-icon"]').each(($el, index) => {
        cy.log($el.text())
        if ($el.text() === 'V4') {
          cy.wrap($el).click()
         selectRaceFuncs.performHorseSelection()
          cy.log('Test case completed.')                           
          return false
        }else{
            cy.get('[data-test-id="quicklinks-calendar-horsebetting"]').click()
            cy.get('[data-test-id="calendar-next-day-button"]').click()
            cy.get('[data-test-id="calendar-menu-gameType-V4"]').click()
        
            selectRaceFuncs.performHorseSelection()
            cy.log('Test case completed.')
            return false
        } 
      })
      
    })
  })


