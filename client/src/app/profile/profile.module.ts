import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProfileRoutingModule } from './profile-routing.module';
import { ProfileComponent } from './profile.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { ActivityTimelineComponent } from './activity-timeline/activity-timeline.component';


@NgModule({
  declarations: [
    ProfileComponent,
    EditProfileComponent,
    ActivityTimelineComponent
  ],
  imports: [
    CommonModule,
    ProfileRoutingModule
  ]
})
export class ProfileModule { }
