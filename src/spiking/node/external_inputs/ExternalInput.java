/**
* This file is part of FNS (Firnet NeuroScience), ver.2.0
*
* (c) 2018, Mario Salerno, Gianluca Susi, Alessandro Cristini, Emanuele Paracone,
* Fernando Maestú.
*
* CITATION:
* When using FNS for scientific publications, cite us as follows:
*
* Gianluca Susi, Pilar Garcés, Alessandro Cristini, Emanuele Paracone, Mario 
* Salerno, Fernando Maestú, Ernesto Pereda (2018). "FNS: an event-driven spiking 
* neural network simulator based on the LIFL neuron model". 
* Laboratory of Cognitive and Computational Neuroscience, UPM-UCM Centre for 
* Biomedical Technology, Technical University of Madrid; University of Rome "Tor 
* Vergata".   
* Paper under review.
*
* FNS is free software: you can redistribute it and/or modify it under the terms 
* of the GNU General Public License version 3 as published by  the Free Software 
* Foundation.
*
* FNS is distributed in the hope that it will be useful, but WITHOUT ANY 
* WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR 
* A PARTICULAR PURPOSE. See the GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License along with 
* FNS. If not, see <http://www.gnu.org/licenses/>.
* -----------------------------------------------------------
* Website:   http://www.fnsneuralsimulator.org
*/


package spiking.node.external_inputs;


import spiking.node.Node;
import utils.tools.NiceQueue;
import utils.tools.NiceNode;

public class ExternalInput {
  
   public final static int POISSON = 0;
   public final static int CONSTANT = 1;
   public final static int NOISE = 2;
   private final static String TAG = "[External Input] ";
   private final static Boolean verbose = true;
   public final static Double EXTERNAL_AMPLITUDE_DEF_VALUE = 0.1;
   //the node which takes the inputs
   private Node n;
   //external input neuron number
   private Integer externalInputs;
   private Double externalInputsTimeOffset=0.1;
   private Integer fireDuration=5;                       //duration in ms
   private double timeStep=1;                            //step
   private int type;  
   private int externalSpikes = 0;
   private Double externalAmplitude = EXTERNAL_AMPLITUDE_DEF_VALUE;
   
     
   public ExternalInput(
     Node n, 
     int type, 
     Double externalInputsTimeOffset, 
     int fireDuration, 
     Double externalAmplitude, 
     double timeStep){
     this.n=n;
     this.type=type;
     this.externalInputsTimeOffset=
         ((externalInputsTimeOffset!=null)&&
         (externalInputsTimeOffset>0))?
           externalInputsTimeOffset:
           this.externalInputsTimeOffset;
     this.fireDuration=fireDuration;
     this.timeStep=timeStep;
     this.externalAmplitude=externalAmplitude;
     init();
   }
   
   private void init(){
     println("external input init...");
     externalInputs=n.getExternalInputs();
     println("external input initialized.");
   }
   
   
   public Double getAmplitudeValue(int extNeuron){
     return externalAmplitude;
   }

   public double getTimeStep(){
     return timeStep;
   }

   
   protected Integer getExternalInputsNum(){
     return externalInputs;
   }
   
   public int getExternalSpikesInQueue(){
     return externalSpikes;
   }
   
   public Integer getFireDuration(){
     return fireDuration;
   }
   
   private void println(String s){
     if (verbose)
       System.out.println(TAG+s);
   }
   
   
   
}
