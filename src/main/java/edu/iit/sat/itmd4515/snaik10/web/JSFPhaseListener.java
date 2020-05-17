/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.snaik10.web;

import java.util.logging.Logger;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author siddhi
 */
public class JSFPhaseListener implements PhaseListener {

    private static final Logger LOG = Logger.getLogger(JSFPhaseListener.class.getName());

    @Override
    public void afterPhase(PhaseEvent event) {

        LOG.info("After Phase:" + event.getPhaseId().toString());

        if (event.getPhaseId() == PhaseId.RENDER_RESPONSE) {

            LOG.info("*****************ENDING SESSION*****************");
        }

    }

    @Override
    public void beforePhase(PhaseEvent event) {

        if (event.getPhaseId() == PhaseId.RESTORE_VIEW) {

            LOG.info("*****************STARTING NEW SESSION*****************");
        }

        LOG.info("Before Phase:" + event.getPhaseId().toString());

    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }

}
