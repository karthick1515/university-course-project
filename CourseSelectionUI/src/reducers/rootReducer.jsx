import { combineReducers } from "redux";
import {getLogin,registerLogin} from "./loginReducer";
import {updateCourse,addCourse,getAllCourses,getCourse,deleteCourse} from "./courseReducer"
import {updateCommittee,addCommittee,getAllCommittees,getCommittee,deleteCommittee} from "./committeeReducer"
import {updateApplicant,addApplicant,getAllApplicants,getApplicant,deleteApplicant,getApplicantCourseId} from "./applicantReducer"
import {updateAdmission,addAdmission,getAllAdmissions,getAdmission,deleteAdmission,getAdmissionByApplicantId} from "./admissionReducer"
import { getStaff,addstaff,getAllStaffs } from "./staffReducers";
const rootReducer = combineReducers({
    getLogin,
    registerLogin,
    getCourse,
    getAllCourses,
    addCourse,
    deleteCourse,
    updateCourse,
    getCommittee,
    getAllCommittees,
    addCommittee,
    deleteCommittee,
    updateCommittee,
    getApplicant,
    getAllApplicants,
    addApplicant,
    deleteApplicant,
    updateApplicant,
    getAdmission,
    getAllAdmissions,
    addAdmission,
    deleteAdmission,
    updateAdmission,
    getApplicantCourseId,
    getStaff,
    addstaff,
    getAllStaffs,
    getAdmissionByApplicantId
});

export default rootReducer;